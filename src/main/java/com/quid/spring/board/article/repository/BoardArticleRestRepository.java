package com.quid.spring.board.article.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.quid.spring.board.article.domain.BoardArticle;
import com.quid.spring.board.article.domain.QBoardArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BoardArticleRestRepository extends JpaRepository<BoardArticle, Long>,
    QuerydslPredicateExecutor<BoardArticle>, QuerydslBinderCustomizer<QBoardArticle> {

    Page<BoardArticle> findByTitleContaining(String title, Pageable pageable);

    Page<BoardArticle> findByContentContaining(String key, Pageable pageable);

    Page<BoardArticle> findByHashtag(String key, Pageable pageable);

    @Override
    default void customize(QuerydslBindings bindings, QBoardArticle root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.title, root.hashtag, root.createdAt, root.createdBy, root.content);
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }

}