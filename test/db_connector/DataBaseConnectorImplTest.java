package db_connector;

import banner_service.Service.Service;
import banner_service.controller.BannerServiceController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by doramedgyasszay on 2017. 01. 11..
 */
public class DataBaseConnectorImplTest{
    private Service service = new Service();
    private BannerServiceController controller = new BannerServiceController(service);


    @Test
    public void checkIfDataExists() throws Exception {
        boolean test = controller.checkClientAPIKEY("{client_id:1, name: Testclient, apikey:QR43}");
        assertEquals(true, test);

    }



}