package anotators;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import type.TradeshiftBlock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class TradeshiftBlockCategoryGoldAnnotator extends JCasAnnotator_ImplBase {

    @Override
    public void process(JCas jCas) throws AnalysisEngineProcessException {
        Scanner train_labels_sc = null;
        try {
//            train_labels_sc = new Scanner(new FileInputStream("data/train/trainLabels_500.csv"));
            train_labels_sc = new Scanner(new FileInputStream("data/test/testLabels_500.csv"));
            Iterator<TradeshiftBlock> tradeshiftBlocks = JCasUtil.select(jCas, TradeshiftBlock.class).iterator();
            while (train_labels_sc.hasNextLine()) {
                TradeshiftBlock bl = tradeshiftBlocks.next();
                bl.setCategory(train_labels_sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static AnalysisEngineDescription getDescription() throws ResourceInitializationException {
        return AnalysisEngineFactory.createEngineDescription(TradeshiftBlockCategoryGoldAnnotator.class);
    }
}
