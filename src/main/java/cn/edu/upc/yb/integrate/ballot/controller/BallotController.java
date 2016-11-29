package cn.edu.upc.yb.integrate.ballot.controller;

import cn.edu.upc.yb.integrate.ballot.model.Ballot;
import cn.edu.upc.yb.integrate.ballot.repository.BallotRepository;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
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

    @RequestMapping(value = "",method = RequestMethod.POST)
    public Object creatBallot(int num,String detail,long deadline){

        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(-1,"没有登陆");
        Ballot ballot = new Ballot(detail,deadline,num);
        ballot = ballotRepository.save(ballot);
        String picsrc = "http://qr.topscan.com/api.php?text=" + ballot.getId();
        ballot.setPicsrc(picsrc);
        return ballotRepository.save(ballot);
    }

    @RequestMapping(value = "/doballot",method = RequestMethod.GET)
    public Object creatBallot(int id){

        if (httpSession.getAttribute("user")==null)
            return new ErrorReporter(-1,"没有登陆");
        Ballot ballot = new Ballot();
        ballot = ballotRepository.save(ballot);
        String picsrc = "http://qr.topscan.com/api.php?text=" + ballot.getId();
        ballot.setPicsrc(picsrc);
        return ballotRepository.save(ballot);
    }


}
