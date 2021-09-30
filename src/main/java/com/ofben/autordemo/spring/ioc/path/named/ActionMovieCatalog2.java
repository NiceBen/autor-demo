package com.ofben.autordemo.spring.ioc.path.named;

import com.ofben.autordemo.spring.ioc.annotation.Genre;
import org.springframework.stereotype.Component;

@Component
@Genre("Action")
public class ActionMovieCatalog2 implements MovieCatalog {
    // ...
}