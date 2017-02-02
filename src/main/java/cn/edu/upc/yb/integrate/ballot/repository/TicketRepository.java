package cn.edu.upc.yb.integrate.ballot.repository;

import cn.edu.upc.yb.integrate.ballot.model.Ballot;
import cn.edu.upc.yb.integrate.ballot.model.Ticket;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jaxlying on 2016/11/29.
 */
public interface TicketRepository extends CrudRepository<Ticket,Integer>{
    Ticket findFirstByBallotAndIsGet(Ballot ballot,int isget);
    Iterable<Ticket> findByBallot(Ballot ballot);
    Iterable<Ticket> findByBallotAndYbid(Ballot ballot, int ybid);
}
