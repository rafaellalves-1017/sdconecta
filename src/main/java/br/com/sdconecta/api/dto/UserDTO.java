package br.com.sdconecta.api.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Long id;
	
	private String login;
	
	@JsonProperty(value ="node_id")
	private String nodeId;

	@JsonProperty(value ="avatar_url")
	private String avatarUrl;
	
	@JsonProperty(value ="gravatar_id")
	private String gravatarId;
	
	private String url;
	
	@JsonProperty(value ="html_url")
	private String htmlUrl;

	@JsonProperty(value ="followers_url")
	private String followersUrl; 

	@JsonProperty(value ="following_url")
	private String followingUrl;
	
	@JsonProperty(value ="gists_url")
	private String gistsUrl;
	
	@JsonProperty(value ="starred_url")
	private String starredUrl;
	
	@JsonProperty(value ="subscritions_url")
	private String subscritionsUrl;
	
	@JsonProperty(value ="organizations_url")
	private String organizationsUrl;
	
	@JsonProperty(value ="events_url")
	private String eventsUrl;
	
	@JsonProperty(value ="received_events_url")
	private String receivedEventsUrl;
	
	private String type;
	
	@JsonProperty(value ="sitea_admin")
	private Boolean siteAdmin;

	private String name;
	
	private String company;
	
	private String blog;
	
	private String location;

	private String email;
	
	private String hireable;
	
	private String bio;
	
	@JsonProperty(value ="twitter_username")
	private String twitterUsername;
	
	@JsonProperty(value ="public_repos")
	private Integer publicRepos;
	
	@JsonProperty(value ="public_gists")
	private Integer publicGists;
	
	private Integer followers;
	
	private Integer following;

	@JsonProperty(value ="created_at")
	private LocalDateTime createdAt;
	
	@JsonProperty(value ="updated_at")
	private LocalDateTime updatedAt;
	
}
