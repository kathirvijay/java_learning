package org.example.common.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO implements Serializable {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
