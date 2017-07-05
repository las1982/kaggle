package runners;

import anotators.TradeshiftBlockClassificationAnnotator;
import anotators.TradeshiftBlockCategoryGoldAnnotator;
import anotators.TradeshiftBlockAnnotator;
import anotators.TradeshiftBlockFeatureAnnotator;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.fit.factory.AggregateBuilder;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.cleartk.ml.jar.JarClassifierBuilder;
import org.cleartk.util.ae.UriToDocumentTextAnnotator;
import org.cleartk.util.cr.UriCollectionReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class TrainModel {
    public static void main(String[] args) throws Exception {
        Collection<File> files = new ArrayList<>();
        files.add(new File("data/train/train_500.csv"));
        CollectionReader reader = UriCollectionReader.getCollectionReaderFromFiles(files);

        AggregateBuilder builder = new AggregateBuilder();
        builder.add(UriToDocumentTextAnnotator.getDescription());
        builder.add(TradeshiftBlockAnnotator.getDescription());
        builder.add(TradeshiftBlockCategoryGoldAnnotator.getDescription());
        builder.add(TradeshiftBlockFeatureAnnotator.getDescription());
//        builder.add(SentenceAnnotator.getDescription()); // Sentence segmentation
//        builder.add(TokenAnnotator.getDescription()); // Tokenization
//        builder.add(DefaultSnowballStemmer.getDescription("English")); // Stemming
        builder.add(TradeshiftBlockClassificationAnnotator.getTrainerDescription());

        SimplePipeline.runPipeline(reader, builder.createAggregateDescription());

        JarClassifierBuilder.trainAndPackage(
                new File("model"),
                "-t", "0");
    }


}

