package anotators;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import type.TradeshiftBlock;
import type.TradeshiftBlockFeature;
import org.cleartk.ml.CleartkAnnotator;
import org.cleartk.ml.Feature;
import org.cleartk.ml.Instance;
import org.cleartk.ml.feature.extractor.CleartkExtractor;
import org.cleartk.ml.feature.extractor.CoveredTextExtractor;
import org.cleartk.ml.jar.DefaultDataWriterFactory;
import org.cleartk.ml.jar.DirectoryDataWriterFactory;
import org.cleartk.ml.jar.GenericJarClassifierFactory;
import org.cleartk.ml.jar.JarClassifierBuilder;
import org.cleartk.ml.libsvm.LibSvmStringOutcomeDataWriter;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class TradeshiftBlockClassificationAnnotator extends CleartkAnnotator<String> {
    private CleartkExtractor<TradeshiftBlock, TradeshiftBlockFeature> extractor;

    @Override
    public void initialize(UimaContext context) throws ResourceInitializationException {
        super.initialize(context);
        this.extractor = new CleartkExtractor<>(
                TradeshiftBlockFeature.class
                , new CoveredTextExtractor<TradeshiftBlockFeature>()
                , new CleartkExtractor.Covered()
        );
    }

    public void process(JCas jCas) throws AnalysisEngineProcessException {

        Collection<TradeshiftBlock> tradeshiftBlocks = JCasUtil.select(jCas, TradeshiftBlock.class);

        for (TradeshiftBlock tradeshiftBlock : tradeshiftBlocks) {
            List<Feature> features = this.extractor.extract(jCas, tradeshiftBlock);
            if (isTraining()) {
                this.dataWriter.write(new Instance<>(tradeshiftBlock.getCategory(), features));
            } else {
                String category = this.classifier.classify(features);
//                type.TradeshiftBlock document = new type.TradeshiftBlock(jCas, 0, jCas.getDocumentText().length());
//                document.setCategory(category);
//                document.addToIndexes();
                System.out.println("classified " + tradeshiftBlock.getCategory() + " as " + category + ". " + tradeshiftBlock.getCategory().equals(category));
            }
        }
    }

    public static AnalysisEngineDescription getTrainerDescription() throws ResourceInitializationException {
        return AnalysisEngineFactory.createEngineDescription(
                TradeshiftBlockClassificationAnnotator.class,
                DefaultDataWriterFactory.PARAM_DATA_WRITER_CLASS_NAME,
                LibSvmStringOutcomeDataWriter.class.getName(),
                DirectoryDataWriterFactory.PARAM_OUTPUT_DIRECTORY,
                new File("model"));
    }

    public static AnalysisEngineDescription getClassifierDescription() throws ResourceInitializationException {
        return AnalysisEngineFactory.createEngineDescription(
                TradeshiftBlockClassificationAnnotator.class,
                CleartkAnnotator.PARAM_IS_TRAINING,
                false,
                GenericJarClassifierFactory.PARAM_CLASSIFIER_JAR_PATH,
                JarClassifierBuilder.getModelJarFile(new File("model")));
    }

}
