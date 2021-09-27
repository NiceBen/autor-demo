package com.ofben.autordemo.spring.path.named;

import com.ofben.autordemo.spring.annotation.Offline;
import org.springframework.stereotype.Component;

@Component
@Offline
public class CachingMovieCatalog implements MovieCatalog {
    // ...
}