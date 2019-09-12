/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "tb_tr_assessment_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssessmentDetail.findAll", query = "SELECT a FROM AssessmentDetail a")
    , @NamedQuery(name = "AssessmentDetail.findById", query = "SELECT a FROM AssessmentDetail a WHERE a.id = :id")
    , @NamedQuery(name = "AssessmentDetail.findByScore", query = "SELECT a FROM AssessmentDetail a WHERE a.score = :score")})
public class AssessmentDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "score")
    private float score;
    @JoinColumn(name = "lesson_criteria", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LessonCriteria lessonCriteria;
    @JoinColumn(name = "assessment", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Assessment assessment;

    public AssessmentDetail() {
    }

    public AssessmentDetail(String id) {
        this.id = id;
    }

    public AssessmentDetail(String id, float score) {
        this.id = id;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public LessonCriteria getLessonCriteria() {
        return lessonCriteria;
    }

    public void setLessonCriteria(LessonCriteria lessonCriteria) {
        this.lessonCriteria = lessonCriteria;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssessmentDetail)) {
            return false;
        }
        AssessmentDetail other = (AssessmentDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.AssessmentDetail[ id=" + id + " ]";
    }
    
}
