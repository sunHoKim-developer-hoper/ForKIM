package com.sunho.kim.beanfind;

import com.sunho.kim.purchase.member.MemberRepository;
import com.sunho.kim.purchase.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class ApplicationFindSameNameBeanTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입 조회 시 같은 타입이 둘 이상 있으면 중복 오류 발생!")
    void findBeanByTypeDupulicate(){
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));
    }


    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, Bean 이름을 지정하면 된다.")
    void findBeanByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        MemberRepository memberRepositoryDupli = ac.getBean("memberRepositoryDupli", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, MemberRepository> beanOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beanOfType.keySet()) {
            System.out.println("key = " + key + " value = "+ beanOfType.get(key));
        }
        assertThat(beanOfType.size()).isEqualTo(2);
    }


    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepositoryDupli() {
            return new MemoryMemberRepository();
        }
    }

}
