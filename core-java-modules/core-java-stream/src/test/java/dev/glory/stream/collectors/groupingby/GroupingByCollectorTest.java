package dev.glory.stream.collectors.groupingby;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GroupingByCollectorTest {

    private static final List<BlogPost> POSTS = List.of(
            new BlogPost("News item 1", "Author 1", BlogPostType.NEWS, 15),
            new BlogPost("News item 1", "Author 1", BlogPostType.NEWS, 15),
            new BlogPost("Tech review 1", "Author 2", BlogPostType.REVIEW, 5),
            new BlogPost("Programming guide", "Author 1", BlogPostType.GUIDE, 20),
            new BlogPost("News item 2", "Author 2", BlogPostType.NEWS, 35),
            new BlogPost("Tech review 2", "Author 1", BlogPostType.REVIEW, 15),
            new BlogPost("News item 3", "Author 1", BlogPostType.NEWS, 50),
            new BlogPost("Tech review 3", "Author 2", BlogPostType.REVIEW, 5),
            new BlogPost("Programming guide 2", "Author 2", BlogPostType.GUIDE, 25),
            new BlogPost("News item 4", "Author 1", BlogPostType.NEWS, 5),
            new BlogPost("Tech review 4", "Author 1", BlogPostType.REVIEW, 5)
    );

    @DisplayName("Simple Grouping by a Single Column")
    @Test
    void grouped_by_type() throws Exception {
        // given

        // when
        Map<BlogPostType, List<BlogPost>> postsPerType = POSTS.stream()
                .collect(groupingBy(BlogPost::type));

        // then
        assertThat(postsPerType.get(BlogPostType.NEWS)).hasSize(5);
        assertThat(postsPerType.get(BlogPostType.REVIEW)).hasSize(4);
        assertThat(postsPerType.get(BlogPostType.GUIDE)).hasSize(2);
    }

    @DisplayName("Getting the Sum from Grouped Results")
    @Test
    void grouped_by_type_and_sum_likes() throws Exception {
        // given

        // when
        Map<BlogPostType, Integer> likesPerType = POSTS.stream()
                .collect(groupingBy(BlogPost::type, summingInt(BlogPost::likes)));

        // then
        assertThat(likesPerType.get(BlogPostType.NEWS)).isEqualTo(120);
        assertThat(likesPerType.get(BlogPostType.REVIEW)).isEqualTo(30);
        assertThat(likesPerType.get(BlogPostType.GUIDE)).isEqualTo(45);
    }

    @DisplayName("Getting the Average from Grouped Results")
    @Test
    void grouped_by_type_and_average_likes() throws Exception {
        // given

        // when
        Map<BlogPostType, Double> averageLikesPerType = POSTS.stream()
                .collect(groupingBy(BlogPost::type, averagingInt(BlogPost::likes)));

        // then
        assertThat(averageLikesPerType.get(BlogPostType.NEWS)).isEqualTo(24);
        assertThat(averageLikesPerType.get(BlogPostType.REVIEW)).isEqualTo(7.5);
        assertThat(averageLikesPerType.get(BlogPostType.GUIDE)).isEqualTo(22.5);
    }

    @DisplayName("Modifying the Returned Map Value Type")
    @Test
    void grouped_by_type_and_delete_duplicate() throws Exception {
        // given

        // when
        Map<BlogPostType, Set<BlogPost>> postTypeSetMap = POSTS.stream()
                .collect(groupingBy(BlogPost::type, toSet()));

        // then
        assertThat(postTypeSetMap.get(BlogPostType.NEWS)).hasSize(4);
        assertThat(postTypeSetMap.get(BlogPostType.REVIEW)).hasSize(4);
        assertThat(postTypeSetMap.get(BlogPostType.GUIDE)).hasSize(2);
    }

    @DisplayName("Grouping by Multiple Fields")
    @Test
    void grouped_by_author_and_type() throws Exception {
        // given

        // when
        Map<String, Map<BlogPostType, List<BlogPost>>> postsByAuthorAndType = POSTS.stream()
                .collect(groupingBy(BlogPost::author, groupingBy(BlogPost::type)));

        // then
        assertThat(postsByAuthorAndType.get("Author 1").get(BlogPostType.NEWS)).hasSize(4);
        assertThat(postsByAuthorAndType.get("Author 1").get(BlogPostType.REVIEW)).hasSize(2);
        assertThat(postsByAuthorAndType.get("Author 1").get(BlogPostType.GUIDE)).hasSize(1);
        assertThat(postsByAuthorAndType.get("Author 2").get(BlogPostType.NEWS)).hasSize(1);
        assertThat(postsByAuthorAndType.get("Author 2").get(BlogPostType.REVIEW)).hasSize(2);
        assertThat(postsByAuthorAndType.get("Author 2").get(BlogPostType.GUIDE)).hasSize(1);
    }

    @DisplayName("Getting a Summary for an Attribute of Grouped Results")
    @Test
    void grouped_by_type_and_summary() throws Exception {
        // given

        // when
        Map<BlogPostType, IntSummaryStatistics> likeStatisticsPerType = POSTS.stream()
                .collect(groupingBy(BlogPost::type, summarizingInt(BlogPost::likes)));

        // then
        System.out.println("==> likeStatisticsPerType = " + likeStatisticsPerType);

        assertThat(likeStatisticsPerType.get(BlogPostType.NEWS).getMax()).isEqualTo(50);
        assertThat(likeStatisticsPerType.get(BlogPostType.NEWS).getMin()).isEqualTo(5);
        assertThat(likeStatisticsPerType.get(BlogPostType.NEWS).getAverage()).isEqualTo(24);
        assertThat(likeStatisticsPerType.get(BlogPostType.NEWS).getSum()).isEqualTo(120);
    }
}