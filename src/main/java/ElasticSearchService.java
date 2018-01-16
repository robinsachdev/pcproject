/**
 * @author: rsachdev
 * @created: 15 Jan, 2018 
 */

public interface ElasticSearchService {
    public String searchByParam(String param, Field field);
    public String getSearchQuery(String param, Field field);
}
