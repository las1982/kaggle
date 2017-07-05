package runners;

import anotators.TradeshiftBlockClassificationAnnotator;
import anotators.TradeshiftBlockCategoryGoldAnnotator;
import anotators.TradeshiftBlockAnnotator;
import anotators.TradeshiftBlockFeatureAnnotator;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.fit.factory.AggregateBuilder;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.cleartk.util.ae.UriToDocumentTextAnnotator;
import org.cleartk.util.cr.UriCollectionReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Aliaksandr_Lashkov on 27.06.2017.
 */
public class RunModel {
    public static void main(String[] args) throws Exception {

        Collection<File> files = new ArrayList<>();
        files.add(new File("data/test/test_500.csv"));
        CollectionReader reader = UriCollectionReader.getCollectionReaderFromFiles(files);

        AggregateBuilder builder = new AggregateBuilder();

        builder.add(UriToDocumentTextAnnotator.getDescription());
        builder.add(TradeshiftBlockAnnotator.getDescription());
        builder.add(TradeshiftBlockCategoryGoldAnnotator.getDescription());
        builder.add(TradeshiftBlockFeatureAnnotator.getDescription());
        builder.add(TradeshiftBlockClassificationAnnotator.getClassifierDescription());

        SimplePipeline.runPipeline(
                reader,
                builder.createAggregateDescription());
    }
}
