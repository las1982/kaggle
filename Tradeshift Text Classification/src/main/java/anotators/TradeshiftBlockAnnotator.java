package anotators;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import type.TradeshiftBlock;
import org.cleartk.util.ViewUriUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class TradeshiftBlockAnnotator extends JCasAnnotator_ImplBase {

    @Override
    public void process(JCas jCas) throws AnalysisEngineProcessException {
        try {
            JCas uriView = jCas.getView(ViewUriUtil.URI);
            URI uri = new URI(uriView.getSofaDataURI());
            File file = new File(uri.getPath());
            Scanner train_sc = new Scanner(new FileInputStream(file));
            int i = 0;
            int len;
            while (train_sc.hasNextLine()) {
                len = train_sc.nextLine().length();
                TradeshiftBlock document = new TradeshiftBlock(jCas, i, i + len);
                String s = document.getCoveredText();
                document.addToIndexes();
                i += len + 2;
            }
        } catch (CASException | URISyntaxException e) {
            throw new AnalysisEngineProcessException(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static AnalysisEngineDescription getDescription() throws ResourceInitializationException {
        return AnalysisEngineFactory.createEngineDescription(TradeshiftBlockAnnotator.class);
    }
}
