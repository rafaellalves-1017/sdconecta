package br.com.sdconecta.api.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {
	
	@Id
	private Long id;
	
	private String login;
	
	private String nodeId;

	private String avatarUrl;
	
	private String gravatarId;
	
	private String url;
	
	private String htmlUrl;

	private String followersUrl; 

	private String followingUrl;
	
	private String gistsUrl;
	
	private String starredUrl;
	
	private String subscritionsUrl;
	
	private String organizationsUrl;
	
	private String eventsUrl;
	
	private String receivedEventsUrl;
	
	private String type;
	
	private Boolean siteAdmin;

	private String name;
	
	private String company;
	
	private String blog;
	
	private String location;

	private String email;
	
	private String hireable;
	
	private String bio;
	
	private String twitterUsername;
	
	private Integer publicRepos;
	
	private Integer publicGists;
	
	private Integer followers;
	
	private Integer following;

	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;

}
