package com.fp.user.dao.domain.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_Time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
