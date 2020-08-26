package com.fp.auth.domain.dataobject;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wcy
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1997659980155645176L;

    @TableId
    private String id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
