package com.liangfang.springai;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
class SpringaiApplicationTests {

	@Test
	public void testDeepSeek(@Autowired DeepSeekChatModel deepSeekChatModel) {
		String content = deepSeekChatModel.call("你好");
		System.out.println(content);
	}

	@Test
	public void testDeepSeekStream(@Autowired DeepSeekChatModel deepSeekChatModel) {
		Flux<String> content = deepSeekChatModel.stream("你好");
		content.toIterable().forEach(System.out::println);
	}

	@Test
	public void testChatClient(@Autowired ChatClient.Builder chatClientBuilder) {
		ChatClient chatClient = chatClientBuilder.build();
		String content = chatClient.prompt().user("你好").call().content();
		System.out.println(content);
	}

	@Test
	public void testPromptChatClient(@Autowired ChatClient.Builder chatClientBuilder) {
		ChatClient chatClient = chatClientBuilder.build();
		String content = chatClient.prompt().system("你是一个相声演员").user("你好").call().content();
		System.out.println(content);
	}

}
