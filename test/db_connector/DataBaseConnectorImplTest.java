package db_connector;

import banner_service.BannerService;
import banner_service.Service.Service;
import banner_service.controller.BannerController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by doramedgyasszay on 2017. 01. 11..
 */
public class DataBaseConnectorImplTest{
    private Service service = Service.getInstance();
    private BannerController controller = new BannerController(service);


    @Test
    public void checkIfDataExists() throws Exception {
        boolean test = controller.checkClientAPIKEY("{client_id:1, name: Testclient, apikey:1234}");
        assertEquals(true, test);

    }



}