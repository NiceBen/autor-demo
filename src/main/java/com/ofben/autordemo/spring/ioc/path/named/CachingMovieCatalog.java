package com.ofben.autordemo.spring.ioc.path.named;

import com.ofben.autordemo.spring.ioc.annotation.Offline;
import org.springframework.stereotype.Component;

@Component
@Offline
public class CachingMovieCatalog implements MovieCatalog {
    // ...
}