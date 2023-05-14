package ai.openfabric.api.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import org.springframework.stereotype.Service;

@Service
public class DockerService {

    public DockerClient dockerClient;

    public DockerService() {
        dockerClient = DockerClientBuilder.getInstance().build();
    }
    public DockerClient connectToDocker() {
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
        return DockerClientBuilder.getInstance(config).build();
    }


    public void startContainer(String containerId) {
        dockerClient.startContainerCmd(containerId);
        System.out.println("Started container: " + containerId);
    }

    public void stopContainer(String containerId) {
        dockerClient.stopContainerCmd(containerId);
        System.out.println("Stopped container: " + containerId);
    }

}
