package com.mysite.sbb.question;


import com.mysite.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.user.SiteUser;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
        private final QuestionRepository questionRepository;

        public List<Question> getList() {
            return this.questionRepository.findAll();
        }
        public Question getQuestion(Integer id) {
            Optional<Question> question = this.questionRepository.findById(id);
            if (question.isPresent()) {
                return question.get();
            }else{
                throw new DataNotFoundException ("질문을 찾을수 없습니다.");
            }
        }
        public Page<Question> getList(int page) {
            List<Sort.Order> sorts = new ArrayList<>();
            sorts.add(Sort.Order.desc("createdDate"));
            Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
            return this.questionRepository.findAll(pageable);
        }
        public void create(String subject, String content, SiteUser user) {
            Question q = new Question();
            q.setSubject(subject);
            q.setContent(content);
            q.setAuthor(user);
            q.setCreatedDate(LocalDateTime.now());
            this.questionRepository.save(q);
        }
        public void modify(Question question, String subject, String content) {
            question.setSubject(subject);
            question.setContent(content);
            question.setModifyDate(LocalDateTime.now());
            this.questionRepository.save(question);
        }

    }


