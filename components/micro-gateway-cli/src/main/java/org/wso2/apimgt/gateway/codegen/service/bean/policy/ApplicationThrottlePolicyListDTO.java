package org.wso2.apimgt.gateway.codegen.service.bean.policy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "")
public class ApplicationThrottlePolicyListDTO {
  
  
  
  private Integer count = null;
  
  
  private List<ApplicationThrottlePolicyDTO> list = new ArrayList<ApplicationThrottlePolicyDTO>();

  
  /**
   * Number of Application Throttling Policies returned.\n
   **/
  @ApiModelProperty(value = "Number of Application Throttling Policies returned.\n")
  @JsonProperty("count")
  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) {
    this.count = count;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("list")
  public List<ApplicationThrottlePolicyDTO> getList() {
    return list;
  }
  public void setList(List<ApplicationThrottlePolicyDTO> list) {
    this.list = list;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationThrottlePolicyListDTO {\n");
    
    sb.append("  count: ").append(count).append("\n");
    sb.append("  list: ").append(list).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
