import com.amazonaws.services.lambda.runtime.*;
import model.CustomInput;

/**
 * @author: rsachdev
 * @created: 11 Jan, 2018 
 */

public class SampleLambdaFunctionHandler implements RequestHandler<CustomInput, String> {

    private ElasticSearchService elasticSearchService;

    @Override
    public String handleRequest(CustomInput input, Context context) {
        elasticSearchService = new ElasticSearchServiceImpl();
        return elasticSearchService.searchByParam(input.getValue(), Field.valueOf(input.getField()));
    }
}
