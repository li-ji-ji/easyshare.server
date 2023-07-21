package com.easyshare.service.impl;

import com.easyshare.entity.Files;
import com.easyshare.mapper.FilesMapper;
import com.easyshare.service.IFilesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author li-ji-ji
 * @since 2023-07-21
 */
@Service
public class FilesServiceImpl extends ServiceImpl<FilesMapper, Files> implements IFilesService {

}
