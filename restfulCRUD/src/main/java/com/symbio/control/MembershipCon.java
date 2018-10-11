package com.symbio.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.symbio.entity.MemberType;
import com.symbio.entity.Membership;
import com.symbio.entity.PointsAccount;
import com.symbio.entity.TransactionDetail;
import com.symbio.service.MembershipService;
import com.symbio.service.PointsManagementService;
import com.symbio.valang.MembershipVoValidator;
import com.symbio.vo.MembershipVo;


@Controller
public class MembershipCon {
	
	@Autowired
	 private MembershipService membershipService ;
	
	@Autowired
	Mapper mapper;
	
	@Autowired
	MembershipVoValidator  membershipVoValidator;
	
	@Autowired
	private PointsManagementService  pointsManagementService;
	
	 // 添加新membership
	 
	 @RequestMapping(value = "memadd", method =RequestMethod.POST)
	    public ModelAndView memadd(MembershipVo membershipVo){
		 ModelAndView mav = new ModelAndView();  
		 if (membershipVo == null) {  
			 System.out.println("空");
	         mav.setViewName("OK"); 
	         mav.addObject("msg", "请输入数据");
	         return mav; 
	        }  
		 BindException errors= new BindException(membershipVo, "target");
		 membershipVoValidator.validate(membershipVo, errors);
		 List<ObjectError> lErrors =  errors.getAllErrors();
		 if(lErrors.size()!=0){
			 mav.setViewName("OK"); 
	         
	         List<String> ErrorsList = new ArrayList<String>();
	         for (Object obj : lErrors){
	        	 ErrorsList.add(((FieldError)obj).getDefaultMessage());
		       }
	         mav.addObject("ErrorsMsg", ErrorsList);
	         return mav;
		 }
		  //打印错误信息
		    for (Object obj : lErrors){
			  
	           System.out.println(((FieldError)obj).getDefaultMessage());

	       }
		  //使用dozermapper映射实体类
		 Membership membership = mapper.map(membershipVo, Membership.class);
		 membershipService.createMemebrship(membership); 
		 mav.addObject("msg", membership.getMembershipId()+"号录入成功");
         mav.setViewName("OK"); 
         return mav;   
	      
	    }	
	 	 //删除membership
	
	 @RequestMapping(value = "/delMembership/{id}",method = RequestMethod.GET)
	    public ModelAndView delMembership(@PathVariable Long id) {
		 ModelAndView mav = new ModelAndView(); 
	        System.out.println("delMembership Delete: " + id);
	        membershipService.cancelMembership(id);
	         // 跳转的页面  
	         mav.setViewName("redirect:/views/OK.jsp"); 
	         return mav;
	    }
	 
	//通过membershipId获取pointTotal
		
		 @RequestMapping(value = "/getPointsTotalByMembershipId/{id}", method = RequestMethod.POST)
		    public void getPointsTotalByMembershipId(@PathVariable Long id,HttpServletResponse response) {
			 System.out.println(id);
		        Integer pointsTotalByMembershipId = membershipService.getPointsTotalByMembershipId(id);
		        System.out.println(pointsTotalByMembershipId);
		       
		        try {
		        	//传给前台
					response.getWriter().write(pointsTotalByMembershipId.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		 
		//通过membershipId获取membertType
			
		 @RequestMapping(value = "/getMemberType/{id}", method = RequestMethod.POST)
		    public void getMemberType(@PathVariable Long id,HttpServletResponse response) {
			 System.out.println(id);
		     MemberType memberTypeByMembershipId = membershipService.getMemberTypeByMembershipId(id);	
		     String memberType = memberTypeByMembershipId.getMemberType();
		        try {
		        	//传给前台
					response.getWriter().write(memberType.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
	 	
		 // 查找所有membership
		
	 @RequestMapping(value = "/getAllMembership")
	    public String  getAllMembership(HttpServletRequest request) {
		 HttpSession session = request.getSession(true);
		List<Membership> memberships = membershipService.getAllMembership();
		session.setAttribute("memberships", memberships);
		Membership m = memberships.get(0);
		
		System.out.println(m.getLastName());
       return "MembershipInfo";
       
	    }
	 
	 
		 // 根据id查找membership
		 
	   @RequestMapping(value = "/getByIdMembership/{id}", method = RequestMethod.GET)
	    public ModelAndView getByIdMembership(@PathVariable Long id) {
	        
		   ModelAndView mav = new ModelAndView();  
		   Membership membership = membershipService.findMembershipByMembershipId(id);
			// 返回的数据  
	         mav.addObject("membership", membership);  
	         // 跳转的页面  
	         mav.setViewName(""); 
	         return mav; 
	    }
	  
		 // 根据id更新membership
		 
	   @RequestMapping(value = "/UMemberhsip")
	   public ModelAndView updateMem(Membership membership){
			 ModelAndView mav = new ModelAndView();   
			 BindException errors= new BindException(membership, "target");
			 membershipVoValidator.validate(membership, errors);
			 List<ObjectError> lErrors =  errors.getAllErrors();
			 if(lErrors.size()!=0){
				 mav.setViewName("OK"); 
		         List<String> ErrorsList = new ArrayList<String>();
		         for (Object obj : lErrors){
		        	 ErrorsList.add(((FieldError)obj).getDefaultMessage());
			       }
		         mav.addObject("ErrorsMsg", ErrorsList);
		         return mav;
			 }
			  //打印错误信息
			    for (Object obj : lErrors){
				  
		           System.out.println(((FieldError)obj).getDefaultMessage());

		       }  
			 membershipService.updateMembership(membership); 
			 mav.addObject("msg", membership.getMembershipId()+"号更新成功");
	         mav.setViewName("OK"); 
	         return mav;   
		      
		    }	
	   
	// 根据memid查找pointAccount
		 
	   @RequestMapping(value = "/getTransactionDetail")
	    public String getTransactionDetail(HttpServletRequest request,@RequestParam Long id) {
		   HttpSession session = request.getSession(true);
		   System.out.println("1111111111111111111111111111");
		    TransactionDetail transactionDetail = membershipService.getTransactionDetailByMembershipId(id);
		    //因为EL是读取属性的getter方法的,一般按照属性首字母小写来处理（前台获取不到这个字段）
		    System.out.println("ReferenceTransDetailId"+transactionDetail.getReferenceTransDetailId());
			// 返回的数据  
	        session.setAttribute("TransactionDetail", transactionDetail);  
	       
	         return "transactionDetail"; 
	    }

	   
		// pointsDeposit
			 
		   @RequestMapping(value = "/pointsDeposit",method = RequestMethod.GET)
		    public ModelAndView pointsDeposit(@RequestParam Long memershipId,Integer pointsNum) {
			 ModelAndView mav = new ModelAndView(); 
			 pointsManagementService.pointsDeposit(pointsNum, memershipId);
			 mav.addObject("msg", "You added "+pointsNum+"points this time.");
		     // 跳转的页面  redirect:/views/
		     mav.setViewName("OK"); 
		     return mav;
		    }
		   
		// pointSpend
			 
		   @RequestMapping(value = "/pointSpend",method = RequestMethod.GET)
		    public ModelAndView pointSpend(@RequestParam Long memershipId,Integer pointsNum) {
			 ModelAndView mav = new ModelAndView(); 
			 pointsManagementService.pointSpend(pointsNum, memershipId);
			 mav.addObject("msg", "You spent "+pointsNum+"points this time.");
		     // 跳转的页面  redirect:/views/
		     mav.setViewName("OK"); 
		     return mav;
		    }
		   
		// transferPoints
			 
		   @RequestMapping(value = "/transferPoints",method = RequestMethod.GET)
		    public ModelAndView transferPoints(@RequestParam Long memershipId1,Long memershipId2,Integer pointsNum) {
			 ModelAndView mav = new ModelAndView(); 
			 pointsManagementService.transferPoints(pointsNum, memershipId1, memershipId2);
			 if(membershipService.getPointsTotalByMembershipId(memershipId1)!=0) {
				 mav.addObject("msg", "Member"+memershipId1+"give "+pointsNum+"points to"+"Member"+memershipId2);
			 }else {
				 mav.addObject("msg", "Member"+memershipId1+"do not have enough points.");
			 }
			 // 跳转的页面  redirect:/views/
		     mav.setViewName("OK"); 
		     return mav;
		    }
		   
		// cancelDeposit
			 
		   @RequestMapping(value = "/cancelDeposit",method = RequestMethod.GET)
		    public ModelAndView cancelDeposit(@RequestParam Long memershipId) {
			 ModelAndView mav = new ModelAndView(); 
			 pointsManagementService.cancelDeposit(memershipId);
			 mav.addObject("msg", "You cancels order, causing points to roll back");
		     // 跳转的页面  redirect:/views/
		     mav.setViewName("OK"); 
		     return mav;
		    }
		   
		// cacelSpend
			 
		   @RequestMapping(value = "/cacelSpend",method = RequestMethod.GET)
		    public ModelAndView cacelSpend(@RequestParam Long memershipId) {
			 ModelAndView mav = new ModelAndView(); 
			 pointsManagementService.cacelSpend(memershipId);
			 mav.addObject("msg", "You cancels order, causing points to roll back");
		     // 跳转的页面  redirect:/views/
		     mav.setViewName("OK"); 
		     return mav;
		    }
		   
		// cleanPoints
			 
		   @RequestMapping(value = "/cleanPoints",method = RequestMethod.GET)
		    public ModelAndView cleanPoints(@RequestParam Date beginDate,Date endDate) {
			 ModelAndView mav = new ModelAndView();  
			 pointsManagementService.cleanPoints(beginDate, endDate);
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			 String bDate = formatter.format(beginDate);
			 String eDate = formatter.format(endDate);
			 mav.addObject("msg", "Clear points between "+bDate+" and " +eDate );
		     // 跳转的页面  redirect:/views/
		     mav.setViewName("OK"); 
		     return mav;
		    }
		   
		   @RequestMapping(value = "/getPointsDetailByDate")
		    public String  getPointsDetailByDate(HttpServletRequest request,@RequestParam Date beginDate,Date endDate) {
			 HttpSession session = request.getSession(true);
			 List<PointsAccount> pointsAccounts = pointsManagementService.getPointsDetailByDate(beginDate, endDate);
			session.setAttribute("pointsAccounts", pointsAccounts);
			return "PointAccount";
	       
		    }   
}
