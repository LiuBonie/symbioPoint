package com.symbio.valang;

import org.springframework.validation.Errors;

import org.springmodules.validation.valang.ValangValidator;

public class MembershipVoValidator extends ValangValidator  {

    public void validate(Object o,Errors e){

       super.validate(o,e);//这里可以有更多内容，为了简化将直接调用验证函数验证规则在第三步中给出

    }

}
