package com.fp.user.dao.dataobject;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wcy
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1997659980155645176L;
    @Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.fp.user.dao.jpa.CustomIdGenerator")
    private String id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

}
