package ex.train.io.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
					new Topic("spring","spring framework","spring framework description"),
					new Topic("java","java core","java core description"),
					new Topic("javascript","Javascript web","Javascript web description")
				));
	
	@HystrixCommand(fallbackMethod = "defaultTopics")
	public List<Topic> getAllTopics() {
		RestTemplate rest = new RestTemplate();
		Topic topic = rest.getForObject("http://localhost:8085/topics", Topic.class);
		List<Topic> topics = new ArrayList<>();
		topics.add(topic);
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic );
				return;
			}
			
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
		
	}
	
	public List<Topic> defaultTopics() {
		System.out.println("----Default Topic - Hysterix------");
		return topics;
	}
}
