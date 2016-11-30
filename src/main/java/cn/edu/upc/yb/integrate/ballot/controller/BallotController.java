package cn.edu.upc.yb.integrate.ballot.controller;

import cn.edu.upc.yb.integrate.ballot.config.BallotConfig;
import cn.edu.upc.yb.integrate.ballot.model.Ballot;
import cn.edu.upc.yb.integrate.ballot.model.Ticket;
import cn.edu.upc.yb.integrate.ballot.repository.BallotRepository;
import cn.edu.upc.yb.integrate.ballot.repository.TicketRepository;
import cn.edu.upc.yb.integrate.ballot.service.BallotService;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "",method = RequestMethod.POST)
    public Object creatBallot(int num,String detail,long deadline){

        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(-1,"没有登陆");
        Ballot ballot = new Ballot(detail,deadline,num);
        ballot = ballotRepository.save(ballot);
        String picsrc = "http://qr.topscan.com/api.php?text=" + ballotConfig.frontedurl + "?" + ballot.getId();
        ballot.setPicsrc(picsrc);
        YibanBasicUserInfo user = ((YibanBasicUserInfo)httpSession.getAttribute("user"));
        ballot.setYibanid(user.visit_user.userid);
        ballot.setYibanName(user.visit_user.username);
        return ballotRepository.save(ballot);
    }

    @RequestMapping(value = "/doballot",method = RequestMethod.GET)
    public Object doBallot(int id){

        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(-1,"没有登陆");
        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo)httpSession.getAttribute("user");
        Ballot ballot = ballotRepository.findOne(id);
        Ticket ticket = new Ticket(ballot,yibanBasicUserInfo.visit_user.userid,yibanBasicUserInfo.visit_user.username);

        int number = new BallotService().getNum(ballot);
        ticket.setNumber(number);
        return ticketRepository.save(ticket);
    }




}
