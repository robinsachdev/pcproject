import com.amazonaws.services.lambda.runtime.Context;
import junit.framework.Assert;
import model.CustomInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author: rsachdev
 * @created: 15 Jan, 2018 
 */

@RunWith(MockitoJUnitRunner.class)
public class SampleLambdaFunctionHandlerTest {

    @InjectMocks
    private SampleLambdaFunctionHandler sampleLambdaFunctionHandler;

    @Mock
    private ElasticSearchService elasticSearchService;

    @Mock
    private Context context;

    @Test
    public void testHandleRequest_PlanName(){
        String param = "param";
        Field field = Field.PLAN_NAME;
        CustomInput input = new CustomInput();
        input.setValue(param);
        input.setField(field.toString());
        String output = sampleLambdaFunctionHandler.handleRequest(input, context);
        Assert.assertNotNull(output);
    }

    @Test
    public void testHandleRequest_SponsorName(){
        String param = "param";
        Field field = Field.SPONSOR_DFE_NAME;
        CustomInput input = new CustomInput();
        input.setValue(param);
        input.setField(field.toString());
        String output = sampleLambdaFunctionHandler.handleRequest(input, context);
        Assert.assertNotNull(output);
    }

    @Test
    public void testHandleRequest_SponsorLocation(){
        String param = "param";
        Field field = Field.SPONS_DFE_MAIL_US_STATE;
        CustomInput input = new CustomInput();
        input.setValue(param);
        input.setField(field.toString());
        String output = sampleLambdaFunctionHandler.handleRequest(input, context);
        Assert.assertNotNull(output);
    }

}
