package quick.pager.shop.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.activity.request.assemble.AssembleRuleSaveRequest;
import quick.pager.shop.activity.response.assemble.AssembleActivityRuleResponse;
import quick.pager.shop.activity.service.AssembleRuleService;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.response.Response;

/**
 * 拼团规则
 *
 * @author siguiyang
 * @version 3.0
 */
@RestController
@RequestMapping(ConstantsClient.ACTIVITY)
public class AssembleRuleController {

    @Autowired
    private AssembleRuleService assembleRuleService;

    /**
     * 规则详情
     *
     * @param activityId 拼团活动主键
     */
    @GetMapping("/assemble/rule/{activityId}")
    public Response<AssembleActivityRuleResponse> rule(@PathVariable("activityId") Long activityId) {
        return assembleRuleService.info(activityId);
    }

    /**
     * 拼团活动规则新增修改
     *
     * @param request 请求参数
     */
    @PutMapping("/assemble/rule/modify")
    public Response<Long> modifyRule(@RequestBody AssembleRuleSaveRequest request) {
        return assembleRuleService.rule(request);
    }
}
