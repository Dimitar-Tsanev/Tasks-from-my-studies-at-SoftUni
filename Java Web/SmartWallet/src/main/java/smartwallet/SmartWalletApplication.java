package smartwallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SmartWalletApplication {

    public static void main ( String[] args ) {
        SpringApplication.run ( SmartWalletApplication.class, args );
    }

}
