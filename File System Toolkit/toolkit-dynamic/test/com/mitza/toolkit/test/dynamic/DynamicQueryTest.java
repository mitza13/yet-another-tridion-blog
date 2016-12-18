package com.mitza.toolkit.test.dynamic;

import com.mitza.toolkit.domain.ComponentMeta;
import com.mitza.toolkit.domain.PageMeta;
import com.mitza.toolkit.query.AndCriteria;
import com.mitza.toolkit.query.Criterion;
import com.mitza.toolkit.query.CustomMetaCriterion;
import com.mitza.toolkit.query.OrCriteria;
import com.mitza.toolkit.query.PublicationCriterion;
import com.mitza.toolkit.query.Query;
import com.mitza.toolkit.query.SchemaCriterion;
import com.mitza.toolkit.query.SortColumn;
import com.mitza.toolkit.query.SortDirection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * @author Mihai Cadariu
 * @since 30.11.2015
 */
public class DynamicQueryTest {

    private final Logger log = LoggerFactory.getLogger(DynamicQueryTest.class);

    public DynamicQueryTest() {
//        long duration = System.currentTimeMillis();
//        log.debug("Start DynamicQueryTest");

        runSchemaCriterionTest();

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< DynamicQueryTest duration {} millis", duration);
    }

    public void loadTest() {
        runCustomMetaCriterionTest();
        runOrPublicationCriterionTest();
        runAndPublicationCriterionTest();
        runOrCriteriaTest();
        runAndCriteriaTest();
        runComplexCriteriaTest();
        runDateRangeQueryTest();
        runPaginationTest();
        runSchemaCriterionTest();
//        runComponentQueryTest();
//        runPageQueryTest();
//        runSortTest();
    }

    public void runSchemaCriterionTest() {
//        long duration = System.currentTimeMillis();
//        log.debug(">>> Start SchemaCriterionTest");

        Criterion criterion = new SchemaCriterion(46);
        Query query = new Query(criterion);

        List<String> uris = query.executeQuery();
//        log.debug("Found uris {}", uris);

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< SchemaCriterionTest duration {} millis", duration);
    }

    public void runCustomMetaCriterionTest() {
//        long duration = System.currentTimeMillis();
//        log.debug(">>> Start CustomMetaCriterionTest");

        Criterion criterion = new CustomMetaCriterion("String", "LOLEK2");
        Query query = new Query(criterion);

        List<String> uris = query.executeQuery();
//        log.debug("Found uris {}", uris);

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< CustomMetaCriterionTest duration {} millis", duration);
    }

    public void runAndCriteriaTest() {
//        long duration = System.currentTimeMillis();
//        log.debug(">>> Start AndCriteriaTest");

        Criterion first = new CustomMetaCriterion("Type", "Product1");
        Criterion second = new CustomMetaCriterion("String", "LOLEK");
        Criterion andCritera = new AndCriteria(first, second);
        Query query = new Query(andCritera);

        List<String> uris = query.executeQuery();
//        log.debug("Found uris {}", uris);

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< AndCriteriaTest duration {} millis", duration);
    }

    public void runOrCriteriaTest() {
//        long duration = System.currentTimeMillis();
//        log.debug(">>> Start OrCriteriaTest");

        Criterion first = new CustomMetaCriterion("String", "LOLEK");
        Criterion second = new CustomMetaCriterion("Type", "Product1");
        Criterion orCritera = new OrCriteria(first, second);
        Query query = new Query(orCritera);

        List<String> uris = query.executeQuery();
//        log.debug("Found uris {}", uris);

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< OrCriteriaTest duration {} millis", duration);
    }

    public void runComplexCriteriaTest() {
//        long duration = System.currentTimeMillis();
//        log.debug(">>> Start ComplexCriteriaTest");

        Criterion first = new CustomMetaCriterion("String", "LOLEK");
        Criterion second = new CustomMetaCriterion("Type", "Product1");
        Criterion third = new CustomMetaCriterion("String", "LOLEK2");
        Criterion orCritera = new OrCriteria(first, second);
        Criterion andCritera = new AndCriteria(orCritera, third);
        Query query = new Query(andCritera);

        List<String> uris = query.executeQuery();
//        log.debug("Found uris {}", uris);

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< ComplexCriteriaTest duration {} millis", duration);
    }

    public void runOrPublicationCriterionTest() {
//        long duration = System.currentTimeMillis();
//        log.debug(">>> Start OrPublicationCriterionTest");

        Criterion criterion = new AndCriteria(
                new CustomMetaCriterion("String", "LOLEK"),
                new OrCriteria(
                        new PublicationCriterion(6),
                        new PublicationCriterion(8)
                )
        );
        Query query = new Query(criterion);

        List<String> uris = query.executeQuery();
//        log.debug("Found uris {}", uris);

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< OrPublicationCriterionTest duration {} millis", duration);
    }

    public void runAndPublicationCriterionTest() {
//        long duration = System.currentTimeMillis();
//        log.debug(">>> Start AndPublicationCriterionTest");

        Criterion criterion = new AndCriteria(
                new PublicationCriterion(6),
                new OrCriteria(
                        new CustomMetaCriterion("String", "LOLEK"),
                        new CustomMetaCriterion("String", "BOLEK")
                )
        );
        Query query = new Query(criterion);

        List<String> uris = query.executeQuery();
//        log.debug("Found uris {}", uris);

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< AndPublicationCriterionTest duration {} millis", duration);
    }

    private void runDateRangeQueryTest() {
//        long duration = System.currentTimeMillis();
//        log.debug(">>> Start DateRangeQueryTest");

        Criterion criterion = new AndCriteria(
                new PublicationCriterion(6),
                new CustomMetaCriterion("Date", new Date(1450673126000L), new Date(1550673206000L), false)
        );
        Query query = new Query(criterion);

        List<String> componentMetas = query.executeQuery();
//        List<ComponentMeta> componentMetas = query.executeComponentQuery();
//        log.debug("Found componentMetas {}", componentMetas);

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< DateRangeQueryTest duration {} millis", duration);
    }

    private void runComponentQueryTest() {
//        long duration = System.currentTimeMillis();
//        log.debug(">>> Start ComponentQueryTest");

        Criterion criterion = new AndCriteria(
                new PublicationCriterion(6),
                new OrCriteria(
                        new CustomMetaCriterion("String", "LOLEK"),
                        new CustomMetaCriterion("String", "BOLEK")
                )
        );
        Query query = new Query(criterion);

        List<ComponentMeta> componentMetas = query.executeComponentQuery();
//        log.debug("Found componentMetas {}", componentMetas);

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< ComponentQueryTest duration {} millis", duration);
    }

    private void runPageQueryTest() {
//        long duration = System.currentTimeMillis();
//        log.debug(">>> Start PageQueryTest");

        Criterion criterion = new AndCriteria(
                new PublicationCriterion(6),
                new CustomMetaCriterion("action", "Index")
        );
        Query query = new Query(criterion);

        List<PageMeta> pageMetas = query.executePageQuery();
//        log.debug("Found pageMetas {}", pageMetas);

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< PageQueryTest duration {} millis", duration);
    }

    private void runSortTest() {
        long duration = System.currentTimeMillis();
        log.debug(">>> Start SortTest");

        Criterion criterion = new OrCriteria(
                new CustomMetaCriterion("String", "LOLEK"),
                new CustomMetaCriterion("String", "BOLEK")
        );
        Query query = new Query(criterion);
        query.addSort("Type", SortDirection.ASCENDING);
        query.addSort(SortColumn.LAST_PUBLISH, SortDirection.DESCENDING);

        List<ComponentMeta> componentMetas = query.executeComponentQuery();
        log.debug("Found componentMetas {}", componentMetas);

        for (ComponentMeta componentMeta : componentMetas) {
            log.debug(" * '{}' last published {}", componentMeta.getTitle(), componentMeta.getLastPublished());
        }

        duration = System.currentTimeMillis() - duration;
        log.debug("<<< SortTest duration {} millis", duration);
    }

    private void runPaginationTest() {
//        long duration = System.currentTimeMillis();
//        log.debug(">>> Start PaginationTest");

        Criterion criterion = new CustomMetaCriterion("String", "LOLEK2");
        Query query = new Query(criterion);
        query.setPage(2);
        query.setPageSize(25);

        List<String> componentMetas = query.executeQuery();
//        List<ComponentMeta> componentMetas = query.executeComponentQuery();
//        log.debug("Found componentMetas {}", componentMetas);

        log.debug("TotalItemCount {}", query.getTotalItemCount());

//        log.debug("Paginated items");
//        for (ComponentMeta componentMeta : componentMetas) {
//            log.debug(" * '{}' ({})", componentMeta.getTitle(), componentMeta.getTcmUri());
//        }

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< PaginationTest duration {} millis", duration);
    }
}
