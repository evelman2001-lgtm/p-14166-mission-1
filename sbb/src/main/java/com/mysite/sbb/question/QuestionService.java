package com.mysite.sbb.question;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import com.mysite.sbb.DataNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
        private final QuestionRepository questionRepository;

        public List<Question> getList() {
            return this.questionRepository.findAll();
        }
        @SneakyThrows
        public Question getQuestion(Integer id) {
            Optional<Question> question = this.questionRepository.findById(id);
            if (question.isPresent()) {
                return question.get();
            }else{
                throw new DataNotFoundException ("질문을 찾을수 없습니다.");
            }
        }
    }


