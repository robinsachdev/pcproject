import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import javax.ws.rs.client.Client;

/**
 * @author: rsachdev
 * @created: 15 Jan, 2018 
 */

@RunWith(MockitoJUnitRunner.class)
public class ElasticSearchServiceImplTest {

    @InjectMocks
    private ElasticSearchServiceImpl elasticSearchService;

    @Mock
    private Client client;

    @Test
    public void testSearchByParam(){
        Assert.assertNotNull(elasticSearchService.searchByParam("param", Field.PLAN_NAME));
    }

    @Test
    public void testGetSearchQuery_PlanName(){
        String param = "param";
        String output = elasticSearchService.getSearchQuery(param, Field.PLAN_NAME);
        Assert.assertNotNull(output);
        Assert.assertTrue(output.contains(Field.PLAN_NAME.toString()));
        Assert.assertTrue(output.contains(param));
    }

    @Test
    public void testGetSearchQuery_SponsorName(){
        String param = "param";
        String output = elasticSearchService.getSearchQuery(param, Field.SPONSOR_DFE_NAME);
        Assert.assertNotNull(output);
        Assert.assertTrue(output.contains(Field.SPONSOR_DFE_NAME.toString()));
        Assert.assertTrue(output.contains(param));
    }

    @Test
    public void testGetSearchQuery_SponsorLocation(){
        String param = "param";
        String output = elasticSearchService.getSearchQuery(param, Field.SPONS_DFE_MAIL_US_STATE);
        Assert.assertNotNull(output);
        Assert.assertTrue(output.contains(Field.SPONS_DFE_MAIL_US_STATE.toString()));
        Assert.assertTrue(output.contains(param));
    }
}
