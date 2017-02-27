package cn.edu.upc.yb.integrate.ballot;

import cn.edu.upc.yb.integrate.IntegrateApplication;
import cn.edu.upc.yb.integrate.ballot.model.Ballot;
import cn.edu.upc.yb.integrate.ballot.model.Ticket;
import cn.edu.upc.yb.integrate.ballot.repository.BallotRepository;
import cn.edu.upc.yb.integrate.ballot.repository.TicketRepository;
import cn.edu.upc.yb.integrate.ballot.service.BallotService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by lylllcc on 2016/12/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrateApplication.class)
@WebAppConfiguration
public class BallotTest {


    @Autowired
    private BallotRepository ballotRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private BallotService ballotService;

    @Test
    public void testBallot() {
        Ballot ballot = ballotRepository.save(new Ballot());
        Ticket ticket = new Ticket();
        ticket.setBallot(ballot);
        ticketRepository.save(ticket);

    



    }
}
