package com.ofben.autordemo.spring.path.named;

import com.ofben.autordemo.spring.annotation.Genre;
import org.springframework.stereotype.Component;

@Component
@Genre("Action")
public class ActionMovieCatalog2 implements MovieCatalog {
    // ...
}