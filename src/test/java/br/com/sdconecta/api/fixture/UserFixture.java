package br.com.sdconecta.api.fixture;

import br.com.sdconecta.api.dto.UserDTO;
import br.com.sdconecta.api.model.User;

public class UserFixture {

	public static UserDTO criarUserDTO() {
		return UserDTO.builder()
				.avatarUrl("https://avatars.githubusercontent.com/u/125750389?v=4")
				.followers(0)
				.followersUrl("https://api.github.com/users/rafaellalves1017/followers")
				.following(0)
				.followingUrl("https://api.github.com/users/rafaellalves1017/following{/other_user}")
				.gistsUrl("https://api.github.com/users/rafaellalves1017/gists{/gist_id}")
				.htmlUrl("https://github.com/rafaellalves1017")
				.id(125750389L)
				.login("rafaellalves1017")
				.name("Rafael Alves")
				.nodeId("U_kgDOB37MdQ")
				.organizationsUrl("https://api.github.com/users/rafaellalves1017/orgs")
				.starredUrl("https://api.github.com/users/rafaellalves1017/starred{/owner}{/repo}")
				.subscritionsUrl("https://api.github.com/users/rafaellalves1017/subscriptions")
				.type("User")
				.url("https://api.github.com/users/rafaellalves1017")
				.build();
	}
	
	public static User criarUser(UserDTO userDTO) {
		return User.builder()
				.avatarUrl(userDTO.getAvatarUrl())
				.followers(userDTO.getFollowers())
				.followersUrl(userDTO.getFollowersUrl())
				.following(userDTO.getFollowing())
				.followingUrl(userDTO.getFollowersUrl())
				.gistsUrl(userDTO.getGistsUrl())
				.htmlUrl(userDTO.getHtmlUrl())
				.id(userDTO.getId())
				.login(userDTO.getLogin())
				.name(userDTO.getName())
				.nodeId(userDTO.getNodeId())
				.organizationsUrl(userDTO.getOrganizationsUrl())
				.starredUrl(userDTO.getStarredUrl())
				.subscritionsUrl(userDTO.getSubscritionsUrl())
				.type(userDTO.getType())
				.url(userDTO.getUrl())
				.build();
	}
	
}
