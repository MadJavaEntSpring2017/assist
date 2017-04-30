package com.bnisler.service.split;

import com.bnisler.entity.Split;
import com.bnisler.service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SplitMapper {

    @Autowired
    private MappingUtils mappingUtils;

    public void mapToEntity(SplitWriteRequest writeRequest, Split split) {
        mappingUtils.copyProperties(writeRequest, split);
    }

    public void mapEntityToDetail(Split split, SplitDetail splitDetail) {
        mappingUtils.copyProperties(split, splitDetail);
    }
}
