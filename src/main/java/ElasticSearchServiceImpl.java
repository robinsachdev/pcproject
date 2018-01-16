import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author: rsachdev
 * @created: 15 Jan, 2018 
 */

public class ElasticSearchServiceImpl implements ElasticSearchService {
    public static final String HOSTNAME = "https://search-pcproject-axbguqgspt2c2rwm5qo67kn2ly.us-west-1.es.amazonaws.com";
    public static final String INDEX_NAME = "pcindex";

    private Client client;

    @Override
    public String searchByParam(String param, Field field) {
        String query = getSearchQuery(param, field);
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(HOSTNAME).append("/").append(INDEX_NAME).append("/").append("_search");
        client = ClientBuilder.newClient();
        Response response = client.target(urlBuilder.toString()).request()
                .post(Entity.entity(query, MediaType.APPLICATION_JSON_TYPE));
        String output = response.readEntity(String.class);
        return output;
    }

    @Override
    public String getSearchQuery(String param, Field field){
        return String.format("{\n" +
                "  \"query\": {\n" +
                "    \"query_string\": {\n" +
                "      \"default_field\": \"%s\",\n" +
                "      \"query\": \"%s\",\n" +
                "      \"default_operator\": \"AND\"\n" +
                "    }\n" +
                "  }\n" +
                "}", field.toString(), param);
    }
}
