package banner_service.Service;

/**
 * Created by svindler on 10.01.2017.
 */
public class Service {

    private static Service instance;

    public static Service getInstance(){
        if (instance == null){
            instance = new Service();
        }
        return instance;
    }

    public void getBanner(){}
}
