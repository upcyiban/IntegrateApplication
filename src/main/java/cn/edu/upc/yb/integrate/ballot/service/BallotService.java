package cn.edu.upc.yb.integrate.ballot.service;

import cn.edu.upc.yb.integrate.ballot.model.Ballot;
import cn.edu.upc.yb.integrate.ballot.model.Ticket;
import cn.edu.upc.yb.integrate.ballot.repository.BallotRepository;
import cn.edu.upc.yb.integrate.ballot.repository.TicketRepository;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Created by Jaxlying on 2016/11/30.
 */
@Service
public class BallotService {

    @Autowired
    private BallotRepository ballotRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public void deleteBallot(int id){
        Ballot ballot = ballotRepository.findOne(id);
        Iterable<Ticket> iterable = ticketRepository.findByBallot(ballot);
        Iterator<Ticket> iterator = iterable.iterator();
        while(iterator.hasNext()){
            Ticket ti = iterator.next();
            ticketRepository.delete(ti);
        }
        ballotRepository.delete(id);

    }
}
