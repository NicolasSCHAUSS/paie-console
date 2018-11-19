package dev.paie.console;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.service.CotisationService;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
@ContextConfiguration(classes = { AppConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class AppTest {

	@Autowired private CotisationService services;
	
	@Test
    public void testApp()
    {
        Integer tailleInit = services.lister().size();
        services.sauver("dumb", "totest", true, new BigDecimal(45.165468), new BigDecimal(45.165468));
        Integer tailleCreation = services.lister().size();
        services.supprimer(tailleCreation-1);
        Integer tailleSuppression = services.lister().size();
        
        assertEquals(tailleInit, tailleSuppression);
    }
}
