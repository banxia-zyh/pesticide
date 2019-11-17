package group.geolo.defectmanager.repository;

import group.geolo.defectmanager.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/11
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("select project from Project project, group.geolo.defectmanager.entity.Personnel personnel" +
            " where :userId = personnel.userId and personnel.projectId = project.id")
    List<Project> findProjectListByUserId(@Param("userId") Integer userId);
}
