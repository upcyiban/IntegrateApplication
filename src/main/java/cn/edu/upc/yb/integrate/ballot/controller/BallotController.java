package cn.edu.upc.yb.integrate.ballot.controller;

import cn.edu.upc.yb.integrate.ballot.config.BallotConfig;
import cn.edu.upc.yb.integrate.ballot.model.Ballot;
import cn.edu.upc.yb.integrate.ballot.model.Ticket;
import cn.edu.upc.yb.integrate.ballot.repository.BallotRepository;
import cn.edu.upc.yb.integrate.ballot.repository.TicketRepository;
import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Jaxlying on 2016/11/29.
 */
@RestController
@RequestMapping("/ballot")
public class BallotController {


    @Autowired
    private BallotRepository ballotRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private BallotConfig ballotConfig;

    @Autowired
    private TicketRepository ticketRepository;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Object creatBallot(int num,String detail,long deadline){

        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(-1,"没有登陆");
        Ballot ballot = new Ballot(detail,deadline,num);
        ballot = ballotRepository.save(ballot);
        String picsrc = "http://qr.topscan.com/api.php?text=" + ballotConfig.frontedurl + "?id=" + ballot.getId();
        System.out.println(picsrc);
        ballot.setPicsrc(picsrc);
        YibanBasicUserInfo user = ((YibanBasicUserInfo)httpSession.getAttribute("user"));

        ballot.setYibanid(user.visit_user.userid);
        ballot.setYibanName(user.visit_user.username);
        ArrayList<Integer> lists = new ArrayList<>();
        for (int i=1;i<=num;i++){
           lists.add(i);
        }

        Collections.shuffle(lists);

        Iterator<Integer> it = lists.iterator();
        while(it.hasNext()){
            Integer in = it.next();
            Ticket ticket = new Ticket(ballot);
            ticket.setNumber(in);
            ticketRepository.save(ticket);
        }

        return ballotRepository.save(ballot);
    }

    @RequestMapping(value = "/doballot",method = RequestMethod.GET)
    public Object doBallot(int id){

        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo)httpSession.getAttribute("user");

        Ballot ballot = ballotRepository.findOne(id);
        Ticket ticket =  ticketRepository.findFirstByBallotAndIsGet(ballot,0);
        ticket.setIsGet(1);
        ticket.setYbid(yibanBasicUserInfo.visit_user.userid);
        ticket.setYbname(yibanBasicUserInfo.visit_user.username);
        ticketRepository.save(ticket);
        return ticket;
    }

    @RequestMapping("/getallballot")
    public Object showAll(){
        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo)httpSession.getAttribute("user");
        return ballotRepository.findByYibanid(yibanBasicUserInfo.visit_user.userid);

    }

    @RequestMapping("/getballot")
    public Object showOne(int id){
        return ticketRepository.findByBallot(ballotRepository.findOne(id));
    }

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public Object delete(int id){
        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(-1,"没有登陆");
        Ballot ballot = ballotRepository.findOne(id);
        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo)httpSession.getAttribute("user");
        if(ballot.getYibanid() == yibanBasicUserInfo.visit_user.userid) {
            ballotRepository.delete(id);
            return new JsonMes(1, "删除成功");
        }else return new JsonMes(0,"没有权限");
    }




}
