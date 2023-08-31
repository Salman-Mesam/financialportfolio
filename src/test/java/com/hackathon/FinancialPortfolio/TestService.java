package com.hackathon.FinancialPortfolio;//package com.conygre.spring.boot.repo;

//import com.hackathon.FinancialPortfolio.repos.StockRepository;
//import com.hackathon.FinancialPortfolio.entities.Stock;
//import com.hackathon.FinancialPortfolio.FinancialPortfolioApplication;
//
//import com.hackathon.FinancialPortfolio.repos.StockRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//import org.junit.runner.RunWith;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//import java.util.stream.Stream;
//import java.util.stream.StreamSupport;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.MatcherAssert.assertThat;
//

/**
 * Created by Nick Todd on 30/08/2017.
 */
//@ExtendWith(SpringExtension.class)
//@DataJpaTest // use an in memory database
//@ContextConfiguration(classes= FinancialPortfolioApplication.class)

public class TestService {
    /*
    @Autowired
    private TestEntityManager manager;

    @Autowired // this is a mock which is injected because of the @DataJpaTest
    private StockRepository repo;

    @Autowired
    private StockRepository discService;



    private int discId;

    @BeforeEach
    public  void setupDatabaseEntryForReadOnlyTests() {
        Stock disc = new Stock("Abba Gold", 12.99, "Abba", 5);
        Stock result = manager.persist(disc);
        discId = result.getId();

    }


    // unit test the repo using a mock database
    @Test
    public void canRetrieveCDByArtist() {
        Iterable<Stock> discs = repo.findByArtist("Abba");
        Stream<Stock> stream = StreamSupport.stream(discs.spliterator(), false);
        assertThat(stream.count(), equalTo(1L));
    }


    // integration test for the service layer and data layer
    @Test
    public void StockRepositoryCanReturnACatalog() {
        Iterable<Stock> discs = discService.getStocks();
        Stream<Stock> stream = StreamSupport.stream(discs.spliterator(), false);
        Optional<Stock> firstDisc = stream.findFirst();
        assertThat(firstDisc.get().getArtist(), equalTo("Abba"));
    }

    // integration test with the controller
    @Test
    public void controllerCanReturnCDById() {
        Stock cd = controller.getCdById(discId);
        assertThat(cd.getArtist(), equalTo("Abba"));
    }
    */
}