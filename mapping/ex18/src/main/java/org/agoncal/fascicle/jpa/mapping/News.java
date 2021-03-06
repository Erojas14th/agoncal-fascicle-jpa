package org.agoncal.fascicle.jpa.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class News {

  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String content;
  @OrderBy("postedDate DESC")
  private List<Comment> comments;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public News() {
  }

  public News(String content) {
    this.content = content;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void addComment(Comment comment) {
    if (comments == null)
      comments = new ArrayList<Comment>();
    comments.add(comment);
  }

  public List<Comment> getComments() {
    return comments;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
