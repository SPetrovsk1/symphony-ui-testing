package Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Header {
    private List<WebElement> headerOptions;
}
