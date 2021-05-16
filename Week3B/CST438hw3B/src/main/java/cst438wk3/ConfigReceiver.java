package cst438wk3;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

@Configuration
public class ConfigReceiver {
	@Bean
	public FanoutExchange fanout() {
		return new FanoutExchange("city-reservation");
	}
	@Bean
	public Queue queue1() {
		return new Queue("city-reservation-q1");
	}
	@Bean
	public Binding binding1(FanoutExchange fanout, Queue queue1) {
		return BindingBuilder.bind(queue1).to(fanout);
	}
	@Bean
	public ReservationEventHandler receiver() {
		return new ReservationEventHandler();
	}
}
