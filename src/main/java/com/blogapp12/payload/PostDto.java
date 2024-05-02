package com.blogapp12.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {
    private long id;
    @NotEmpty
    @Size(min=3,message = "title should be atleast 3 characters")
    private String title;
    @NotEmpty
    @Size(min=3,message = "description should be atleast 3 characters")
    private String description;
    private String content;


}
